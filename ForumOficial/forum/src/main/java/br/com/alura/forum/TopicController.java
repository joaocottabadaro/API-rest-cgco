package br.com.alura.forum;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic.domain.Topic;




@RestController
public class TopicController {
	
	@RequestMapping("/api/topics")
	public List<TopicBriefOutputDto> listTopics(){
	
		Category subcategory = new Category("java", new Category("programação"));
		Course course = new Course("java and jsf", subcategory);
		Topic topic = new Topic("problemas","string2",
				new User("string", "string2", "1234"),course);
		List<Topic> topics = Arrays.asList(topic, topic, topic);
		return topicsBriefOutputDto.listfromTopics(topics);
					
	}
}
