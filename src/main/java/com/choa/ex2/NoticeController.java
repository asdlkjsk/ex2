package com.choa.ex2;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeService;
import com.choa.util.RowMaker;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	
	@Inject	//data type
	private NoticeService noticeService;
	
	//list
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public void noticeList(Model model, @RequestParam(defaultValue = "1") Integer curPage) throws Exception{
		List<NoticeDTO> ar = noticeService.noticeList(curPage);
		model.addAttribute("list" , ar);
	}
	
	//view
	@RequestMapping(value = "noticeView", method = RequestMethod.GET)
	public void noticeView(Integer num, Model model) throws Exception{
		NoticeDTO noticeDTO = noticeService.noticeView(num);
		model.addAttribute("dto", noticeDTO);
	}	
	
	//Form
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public void noticeWrite(){
		
	}
	
	//write
		@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
		public String noticeWrite(NoticeDTO noticeDTO, RedirectAttributes rd) throws Exception{
			int result=noticeService.noticeWrite(noticeDTO);
			String message = "FAIL";
			if(result>0){
				message = "SUCCESS";
			}
			rd.addFlashAttribute("message", message);	//주소창에 파라미터는 안써짐
			//rd.addAttribute(arg0);	//주소창에 파라미터가 남음
			/*return "notice/result"; forward*/
			return "redirect:noticeList";	//redirect
			//return "redirect:/notice/noticeList?curPage=2";	//redirect 파라미터 넘기는법 / redirect 는 직접 주소쳐서 들어가는거임 ㅎ
		}
			
	/*//write
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO, Model model) throws Exception{
		int result=noticeService.noticeWrite(noticeDTO);
		String message = "FAIL";
		if(result>0){
			message = "SUCCESS";
		}
		model.addAttribute("message", message);
		return "notice/result"; forward
		return "redirect:noticeList";	//redirect
		//return "redirect:noticeList?curPage=2";	//redirect 파라미터 넘기는법 / redirect 는 직접 주소쳐서 들어가는거임 ㅎ
	}*/
	
	//Form
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public void noticeUpdate(Integer num, Model model) throws Exception{
		NoticeDTO noticeDTO = noticeService.noticeView(num);
		model.addAttribute("dto", noticeDTO);
	}
	//update
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, RedirectAttributes rd) throws Exception{
		int result = noticeService.noticeUpdate(noticeDTO);
		String message = "FAIL";
		if(result>0){
			message="SUCCESS";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:noticeList?curPage=1";
	}
	
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public String noticeDelete(Integer num, RedirectAttributes rd) throws Exception{
		int result = noticeService.noticeDelete(num);
		String message = "FFFF";
		if(result>0){
			message = "SSS";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:/notice/noticeList";
	}
}
