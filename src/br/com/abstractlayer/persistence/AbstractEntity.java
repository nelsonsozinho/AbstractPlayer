package br.com.abstractlayer.persistence;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractEntity) {
			AbstractEntity entity = (AbstractEntity) obj;
			if (entity.getId() == this.getId()) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
