package com.example.chat.views.chat;

import com.example.chat.Application;
import com.example.chat.question.Question;
import com.example.chat.views.main.MainView;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.scopes.VaadinUIScope;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.vaadin.artur.Avataaar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Route(value = "chat", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Chat")
@CssImport("styles/views/chat/chat-view.css")
@Component
@Scope(VaadinUIScope.VAADIN_UI_SCOPE_NAME)
public class ChatView extends VerticalLayout {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private final UI ui;
	private final MessageList messageList = new MessageList();
	private final TextField message = new TextField();
	Label label;
	Button max;
	HorizontalLayout inputLayout;
	Icon s=new Icon(VaadinIcon.CARET_RIGHT);
	Icon ss= new Icon(VaadinIcon.LINE_H);
	Icon sss= new Icon(VaadinIcon.COMMENT_ELLIPSIS);
	Avataaar av = new Avataaar("Name");

	private final ScheduledExecutorService executorService;

	public ChatView(ScheduledExecutorService executorService) {

		this.executorService = executorService;
		ui = UI.getCurrent();
		
		message.setPlaceholder("Enter a message...");
//		System.out.println("1");
		message.setSizeFull();
		
		s.addClassName("icons");
		ss.addClassName("icons2");
		
		Button send = new Button(s,event -> sendMessage());
		Button min = new Button(ss, event -> messs());
		min.addClassName("min");
		sss.addClassName("icons3");
		max =new Button(sss, event -> mess());
		max.addClassName("button2");
		av.setId("hi");

		send.addClickShortcut(Key.ENTER);
		send.addClassName("sendButton");

		inputLayout = new HorizontalLayout(message, send);
		inputLayout.addClassName("inputLayout");
		

		label = new Label("Chat With Bot");
		label.addClassName("label");
		label.add(min);
	
		add(max);
		max.setVisible(false);

		add(label,messageList,inputLayout);
		expand(messageList);
		setSizeFull();
		messageList.addMessage("Alice", new Avataaar("Alice2"), "Hi,May i help you", false);
	}

	private void mess() {
		messageList.setVisible(true);
		inputLayout.setVisible(true);
	
		label.setVisible(true);
		max.setVisible(false);
	}

	private void messs() {
		
		messageList.setVisible(false);

		inputLayout.setVisible(false);
		label.setVisible(false);
		max.setVisible(true);
		
		
	}

	private void sendMessage() {
		String text = message.getValue();
		
		messageList.addMessage("You",new Avataaar("Name"), text, true);
		message.clear();

		executorService.schedule(() -> {
			String[] result = text.split(" ");
			List<String> list1 = new ArrayList<String>();
			List<String> list2 = new ArrayList<String>();
			HashSet<String> set = new HashSet<String>();
			
			List<Integer> sd = new ArrayList<Integer>();
			for (String str : result) {
				List<Question> answer = Application.getQusetion(str);
				answer.forEach(hg -> {
					set.add(hg.getAnswer());
					list1.add(hg.getAnswer());
				});

			}
			
			set.forEach(ff->{
				int sa=Collections.frequency(list1, ff);
				if(sd.isEmpty()) {
					list2.add(ff);
					sd.add(sa);
					
				}else {
					if(sd.get(0)<sa) {
						sd.clear();
						list2.clear();
						sd.add(sa);
						list2.add(ff);
					}
				}

			});

			if(list2.get(0).contains("http")) {
				ui.access(() -> messageList.addMessages("Alice", new Avataaar("Alice2"), list2.get(0), false));
			}else {
				ui.access(() -> messageList.addMessage("Alice", new Avataaar("Alice2"), list2.get(0), false));
			}
			


		}, new Random().ints(1000, 3000).findFirst().getAsInt(), TimeUnit.MILLISECONDS);
	}

}
