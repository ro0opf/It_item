package com.it_item_server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it_item_server.model.Sample;

@RestController
public class SampleController {


	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Sample> test() {

		List<Sample> list = new ArrayList<Sample>();

		for (int i = 0; i <= 10; i++) {

			Sample a = new Sample();

//			a.setSeq(i);
			a.setText("TEXT" + i);
			a.setTitle("Title" + i);
			a.setWriter("Writer" + i);

			list.add(a);
		}

		return list;

	}

	@RequestMapping(value = "sample/{seq}", method = RequestMethod.GET)
	public Sample detail(@PathVariable("seq") long seq) {

		Sample s = new Sample();

//		s.setSeq(seq);
		s.setText("TEXT");
		s.setTitle("TITLE");
		s.setWriter("Writer");

		return s;
	}

}
