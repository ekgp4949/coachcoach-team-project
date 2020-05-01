package com.coachcoach.web.myPage;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coachcoach.domain.Member;
import com.coachcoach.domain.Weight;
import com.coachcoach.domain.WorkoutList;
import com.coachcoach.service.MemberService;
import com.coachcoach.service.WeightService;
import com.coachcoach.service.WorkoutListService;

@Controller
@RequestMapping("/myPage/detailData")
public class DetailDataController {

  static Logger logger = LogManager.getLogger(DetailDataController.class);

  @Autowired
  HttpSession httpSession;
  @Autowired
  ServletContext servletContext;
  @Autowired
  WorkoutListService workoutListService;
  @Autowired
  WeightService weightService;
  @Autowired
  MemberService memberService;

  // 운동내역 새로 등록
  @PostMapping("addForm") // 날짜, 운동, 걸음수 등 기입
  public void addForm(int memberNo, Model model) throws Exception {
    Member member = (Member) httpSession.getAttribute("loginUser");
    model.addAttribute("member", member);
  }

  @PostMapping("add")
  public void add(WorkoutList workoutList) throws Exception {
    System.out.println(workoutList.getMemberNo());
    if (workoutListService.add(workoutList) > 0) {
    } else {
      throw new Exception("프로그램을 추가할 수 없습니다.");
    }
  }

  // 운동내역 리스트
  @GetMapping("list") // detailData 페이지 (여기에는 그래프가 나와야 함)
  public void list(Model model) throws Exception {
    Member member = (Member) httpSession.getAttribute("loginUser");
    model.addAttribute("list", workoutListService.list(member.getNo()));
    model.addAttribute("memberNo", member.getNo());
  }

  // 나의 몸무게 기입
  @PostMapping("weightAddForm")
  public void weightAddForm(int memberNo, Model model) throws Exception {
    Member member = (Member) httpSession.getAttribute("loginUser");
    model.addAttribute("member", member);
  }

  @PostMapping("weightAdd")
  public void weightAdd(Weight weight) throws Exception {
    System.out.println(weight.getMemberNo());
    if (weightService.add(weight) > 0) {
    } else {
      throw new Exception("회원 번호가 유효하지 않습니다.");
    }
  }

  // 나의 몸무게 리스트
  @GetMapping("weightList") // detailData 페이지 (여기에는 그래프가 나와야 함)
  public void weightList(Model model) throws Exception {
    Member member = (Member) httpSession.getAttribute("loginUser");
    model.addAttribute("findAllByMemberNo", weightService.findAllByMemberNo(member.getNo()));
    model.addAttribute("memberNo", member.getNo());
  }


  @GetMapping("updateForm") // 날짜, 운동, 몸무게, 걸음수 등 수정
  public void updateForm() {}

  @PostMapping("update")
  public void update() {}

  @GetMapping("delete")
  public void delete() {}



  // Workout Graph
  @GetMapping("workoutGraph")
  public void workoutGraph() {}

  @GetMapping("workoutGraphMonth")
  public void workoutGraphMonth() {}

  @GetMapping("workoutGraphWeek")
  public void workoutGraphWeek() {}

  @GetMapping("workoutGraphYear")
  public void workoutGraphYear() {}


  // @RequestMapping("workoutGraph")
  // public void workoutGraph(HttpServletResponse httpServletResponse,
  // @RequestParam(value = "memberNo") String memberNo) {
  // logger.debug("detailDataController - workoutGraph 실행");
  // List<WorktoutList> list = workoutListService.
  // }


}
