package br.com.alura.forum;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic.domain.Topic;




@RestController
public class TopicController {
	
	@GetMapping(value = "api/topics", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TopicBriefOutputDto> lista(){
	
		Category subcategory = new Category("java", new Category("programação"));
		Course course = new Course("java and jsf", subcategory);
		Topic topic = new Topic("problemas","string2",
				new User("string", "string2", "1234"), course);
		
		List<Topic> topics = Arrays.asList(topic, topic, topic);
		
		return  TopicBriefOutputDto.listFromTopics(topics);
					
	}
}
