package com.zola.study.entity;

public class FastaEntity {
	String name;
	String sequence;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return "FastaEntity [name=" + name + ", sequence=" + sequence + "]";
	}
}
