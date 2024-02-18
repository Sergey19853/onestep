package edu.examples.java_classes.entity;

import java.util.Objects;

public class Medicines {

	private String nameMedicine;
	private String pharmacy;
	private String instructions;
	private Integer amount;
	
	public Medicines() {}

	public Medicines(String nameMedicine, String pharmacy, String instructions, Integer amount) {
		this.nameMedicine = nameMedicine;
		this.pharmacy = pharmacy;
		this.instructions = instructions;
		this.amount = amount;
	}

	public String getNameMedicine() {
		return nameMedicine;
	}

	public void setNameMedicine(String nameMedicine) {
		this.nameMedicine = nameMedicine;
	}

	public String getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, instructions, nameMedicine, pharmacy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicines other = (Medicines) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(instructions, other.instructions)
				&& Objects.equals(nameMedicine, other.nameMedicine) && Objects.equals(pharmacy, other.pharmacy);
	}

	@Override
	public String toString() {
		return "Medicines [nameMedicine=" + nameMedicine + ", pharmacy=" + pharmacy + ", instructions=" + instructions
				+ ", amount=" + amount + "]";
	}
	
}
