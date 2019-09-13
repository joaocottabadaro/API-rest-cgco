import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.model.topic.domain.TopicStatus;

public class TopicBriefOutputDto {

	private Long id;
	private String shortDescription;
	private long secondsSinceLastUpdate;
	private String ownerName;
	private String courseName;
	private	String	subcategoryName;
	private	String	categoryname;
	private	int numberOfResponses;
	private boolean solved;
	
	public TopicBriefOutputDto(Topic topic) {
		this.id = topic.getId();
		this.shortDescription = topic.getShortDescription();
		this.secondsSinceLastUpdate = getSecondsSince(topic.getLastUpdate());
		this.ownerName = topic.getOwner().getName();
		this.courseName = topic.getCourse().getName();
		this.subcategoryName = topic.getCourse().getSubcategory().getName();
		this.numberOfResponses = topic.getNumberOfAnswers();
		this.solved = TopicStatus.NOT_SOLVED.equals(topic.getStatus());
	}

	private long getSecondsSince(Instant lastUpdate) {
		// TODO Auto-generated method stub
		return Duration.between(lastUpdate,  Instant.now())
				.get(ChronoUnit.SECONDS);
		
	}
}
