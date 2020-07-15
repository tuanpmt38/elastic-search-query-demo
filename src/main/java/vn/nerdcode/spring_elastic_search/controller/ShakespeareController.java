package vn.nerdcode.spring_elastic_search.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.nerdcode.spring_elastic_search.base.PageResponse;
import vn.nerdcode.spring_elastic_search.entity.Shakespeare;
import vn.nerdcode.spring_elastic_search.service.ShakespeareService;

@RestController
@RequestMapping("api/v1/shakespeare")
public class ShakespeareController {

  @Autowired
  private ShakespeareService shakespeareService;

  @GetMapping
  public ResponseEntity<PageResponse<Shakespeare>> getAll(Pageable pageable) {
    Page<Shakespeare> result = shakespeareService.findAll(pageable);
    return ResponseEntity.ok(PageResponse.<Shakespeare>builder()
        .data(result.getContent())
        .totalElements(result.getTotalElements())
        .totalPages(result.getTotalPages())
        .pageIndex(result.getNumber()).build());
  }

  @GetMapping("play-name")
  public ResponseEntity<List<Shakespeare>> getByName(@RequestParam String playName) {
    return ResponseEntity.ok(shakespeareService.findByPlayName(playName));
  }

  @GetMapping("search")
  public ResponseEntity<List<Shakespeare>> getListShakespeare (@RequestParam Integer lineId){

    List<Shakespeare> lists = shakespeareService.findAllByName(lineId);
    return ResponseEntity.ok(lists);

  }

  @GetMapping("all")
  public ResponseEntity<List<Shakespeare>> getListAll(){

    List<Shakespeare> lists = shakespeareService.findAllShakespeare();
    return ResponseEntity.ok(lists);

  }

  @GetMapping("range")
  public ResponseEntity<List<Shakespeare>> getListAllByRange(@RequestParam Integer lineId_1, @RequestParam Integer lineId_2 ){

    List<Shakespeare> lists = shakespeareService.findAllShakespeareByLineId(lineId_1, lineId_2);
    return ResponseEntity.ok(lists);

  }

  @GetMapping("page")
  public ResponseEntity<PageResponse<Shakespeare>> getAllPage(@RequestParam Integer lineId, Pageable pageable) {
    Page<Shakespeare> result = shakespeareService.findAllPage(lineId, pageable);
    return ResponseEntity.ok(PageResponse.<Shakespeare>builder()
            .data(result.getContent())
            .totalElements(result.getTotalElements())
            .totalPages(result.getTotalPages())
            .pageIndex(result.getNumber()).build());
  }
}
