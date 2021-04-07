package com.springboot.io.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
 private List <Topic> topics=new ArrayList<>( Arrays.asList(
		new Topic("Spring","Spring Framework","Spring Framework Description"),
		new Topic("java","Core java","Core java Description"),
		new Topic("javascript","javascript","javascript description")
		));
 public List<Topic>getAllTopics(){
	 return topics;
 }
 
 public Topic gettopic(String id) {
	 return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
 }

public void addTopic(Topic topic) {
	topics.add(topic);
	
}

public void updateTopic(String id,Topic topic) {
	for(int i=0;i<topics.size();i++) {
		Topic t=topics.get(i);
		if(t.getId().equals(id)) {
			topics.set(i, topic);
			return;
		}
	}
	
}

public Object deleteTopic(String id) {
	topics.removeIf(t->t.getId().equals(id));
	return null;
}
}
