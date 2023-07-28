package com.example.DepartmentApi.entity;

import java.util.Objects;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.Temporal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deprtmentId;
	@NotBlank(message = "Department Name is mandatory")
	@Length(max = 30,message = "Department Size too Large")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
	public Department() {
		super();
	}
	public Department(int deprtmentId, String departmentName, String departmentAddress, String departmentCode) {
		super();
		this.deprtmentId = deprtmentId;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentCode = departmentCode;
	}
	
	

	@Override
	public String toString() {
		return "Department [deprtmentId=" + deprtmentId + ", departmentName=" + departmentName + ", departmentAddress="
				+ departmentAddress + ", departmentCode=" + departmentCode + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(departmentAddress, departmentCode, departmentName, deprtmentId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(departmentAddress, other.departmentAddress)
				&& Objects.equals(departmentCode, other.departmentCode)
				&& Objects.equals(departmentName, other.departmentName) && deprtmentId == other.deprtmentId;
	}
}
