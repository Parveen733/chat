package com.example.chat.views.chat;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;

import org.vaadin.artur.Avataaar;

public class MessageList extends Div {

	public MessageList() {

		setClassName(getClass().getSimpleName());
	}

	public void addMessage(String from, Avataaar avatar, String text, boolean isCurrentUser) {

		Span fromContainer = new Span(new Text(from));
		fromContainer.addClassName(getClass().getSimpleName() + "-name");

		Div textContainer = new Div(new Text(text));

		textContainer.addClassName(getClass().getSimpleName() + "-bubble");

		Div avatarContainer = new Div(avatar, fromContainer);
		avatarContainer.addClassName(getClass().getSimpleName() + "-avatar");
		Div line = new Div(avatarContainer, textContainer);
		line.addClassName(getClass().getSimpleName() + "-row");
		add(line);
		if (isCurrentUser) {
			line.addClassName(getClass().getSimpleName() + "-row-currentUser");
			textContainer.addClassName(getClass().getSimpleName() + "-bubble-currentUser");
		}
		line.getElement().callJsFunction("scrollIntoView");
	}

	public void addMessages(String from, Avataaar avatar, String text, boolean isCurrentUser) {
		Span fromContainer = new Span(new Text(from));
		fromContainer.addClassName(getClass().getSimpleName() + "-name");

		String start = null;
		String url = null;
		String end = null;
		if (text.contains("http")) {
			int i = text.indexOf("http");
			int k = text.lastIndexOf(" ");// searching space from last index

			int j = (k + 1 == i) ? text.length() : text.indexOf(" ", i);
			start = (i == 0) ? "" : text.substring(0, i);
			url = text.substring(i, j);
			end = (text.length() > (start.length() + url.length())) ? text.substring(j, text.length()) : "";
		}

		Div textContainer = new Div(new Text(start), new Anchor(url, url), new Text(end));

		textContainer.addClassName(getClass().getSimpleName() + "-bubble");

		Div avatarContainer = new Div(avatar, fromContainer);
		avatarContainer.addClassName(getClass().getSimpleName() + "-avatar");

		Div line = new Div(avatarContainer, textContainer);
		line.addClassName(getClass().getSimpleName() + "-row");
		add(line);

		if (isCurrentUser) {
			line.addClassName(getClass().getSimpleName() + "-row-currentUser");

		}

		line.getElement().callJsFunction("scrollIntoView");
	}

}
