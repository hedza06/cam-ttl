package com.hedza06.camttl.domain;import lombok.AllArgsConstructor;import lombok.Data;import lombok.NoArgsConstructor;import javax.persistence.Column;import javax.persistence.Entity;import javax.persistence.GeneratedValue;import javax.persistence.GenerationType;import javax.persistence.Id;import java.io.Serializable;@Data@Entity@NoArgsConstructor@AllArgsConstructorpublic class Sms implements Serializable {    @Id    @Column(updatable = false, nullable = false)    @GeneratedValue(strategy = GenerationType.IDENTITY)    private Integer id;}