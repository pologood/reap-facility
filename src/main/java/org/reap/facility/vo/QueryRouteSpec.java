/*
 * Copyright (c) 2018-present the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.reap.facility.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.reap.facility.common.Fields;
import org.reap.facility.domain.Route;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

/**
 * {@link Route} 实体检索条件值对象.
 * 
 * @author 7cat
 * @since 1.0
 */
public class QueryRouteSpec {

	private String name;

	private String path;

	private String systemCode;

	public Specification<Route> toSpecification() {

		return new Specification<Route>() {

			@Override
			public Predicate toPredicate(Root<Route> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicate = new ArrayList<>();
				if (StringUtils.hasText(getName())) {
					predicate.add(cb.like(root.get(Fields.NAME), "%" + getName() + "%"));
				}

				if (StringUtils.hasText(getPath())) {
					predicate.add(cb.like(root.get(Fields.PATH), "%" + getPath() + "%"));
				}

				if (StringUtils.hasText(getSystemCode())) {
					predicate.add(cb.like(root.get(Fields.SYSTEM_CODE), "%" + getSystemCode() + "%"));
				}

				query.where(predicate.toArray(new Predicate[predicate.size()]));
				return query.getRestriction();
			}

		};

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
}
