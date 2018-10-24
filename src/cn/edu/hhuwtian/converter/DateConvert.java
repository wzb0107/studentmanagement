package cn.edu.hhuwtian.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConvert implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if (source != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			try {
				date = (Date) sdf.parseObject(source);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
			

		}
		return null;
	}

}
