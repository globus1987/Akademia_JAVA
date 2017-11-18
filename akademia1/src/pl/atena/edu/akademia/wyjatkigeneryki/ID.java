package pl.atena.edu.akademia.wyjatkigeneryki;

import java.util.logging.Logger;

public class ID<T> extends AId {
	T value;

	public ID(final T value) {
		this.value=value;
	}

	@Override
	public String przedstawSie() {
		return this.value.toString();
	}

	public <T extends AId> void przypiszId(final T id) {
		Logger.getGlobal().info(String.format("dosta³em takie ID %s", id.przedstawSie()));
	}
}
