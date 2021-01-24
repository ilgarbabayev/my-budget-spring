package com.mybudget.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @NotBlank
    @Column(name = "trans_type")
    private TransactionType type;

    @NotNull
    private BigDecimal amount;

    private String note;

    @ManyToMany
    @JoinTable(name = "trans_tag",
            joinColumns = { @JoinColumn(name = "trans_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    private Set<Tag> tags = new HashSet<>();

    private Instant createdDate;

    public void addTag(Tag tag){
        this.getTags().add(tag);
        tag.getTransactions().add(this);
    }

    public void removeTag(Tag tag){
        this.getTags().remove(tag);
        tag.getTransactions().remove(this);
    }
}
