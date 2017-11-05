package pl.atena.edu.akademia.wyjgen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class MObiekt {
	private Logger log = Logger.getLogger("MObiekt");

	public <T> void przypiszId(final T id) {
		T mId = id;
		this.logujInfo(mId);
	}

	public <T> void przypiszId(final T id1, final T id2) {
		List<T> list = new ArrayList<>();
		list.add(id1);
		list.add(id2);
		this.logujInfo(list);
	}

	public <L> void logujInfo(final L value) {
		this.log.info(this.log.getName()+":"+value.toString());
	}

	public static void main(final String[] args) throws SecurityException, IOException {
		MObiekt o = new MObiekt();
		o.przypiszId(20);
		o.przypiszId("Jan", 23);
		o.przypiszId(new Date());
	}

}
