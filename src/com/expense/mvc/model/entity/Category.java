package com.expense.mvc.model.entity;

// Generated Jul 12, 2012 1:19:22 PM by Hibernate Tools 3.4.0.CR1. Customized by Bala.
//Customization - 1. Field level Annotations
//				- 2. Extends Entity for ToString Implementation.

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category")
public class Category extends com.expense.mvc.model.BaseEntity implements java.io.Serializable, Comparable<Category> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	private Integer categoryId;

	@Column(name = "DATA_KEY", nullable = false)
	private int dataKey;

	@Column(name = "MAIN_CATEGORY", length = 25)
	private String mainCategory;

	@Column(name = "SUB_CATEGORY", length = 25)
	private String subCategory;

	@Column(name = "STATUS", length = 1)
	private Character status;

	public enum Status {
		ACTIVE('A'), INACTIVE('I');

		public char status;

		private Status(char status) {
			this.status = status;
		}
	}

	@Column(name = "DISPLAY_ORDER")
	private Short displayOrder;

	@SuppressWarnings("deprecation")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	@Cascade({ CascadeType.DELETE_ORPHAN, CascadeType.ALL })
	private Set<Transaction> transactions = new HashSet<Transaction>(0);

	public Category() {
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public int getDataKey() {
		return dataKey;
	}

	public void setDataKey(int dataKey) {
		this.dataKey = dataKey;
	}

	public String getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Short getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Short displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public int compareTo(Category o) {
		if (o.displayOrder == null) {
			return -1;
		} else if (displayOrder == null) {
			return 1;
		} else {
			return displayOrder.compareTo(o.displayOrder);
		}
	}
}
