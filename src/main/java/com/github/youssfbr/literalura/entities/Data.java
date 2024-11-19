package com.github.youssfbr.literalura.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;
    private String next;
    private String previous;

    @OneToMany(mappedBy = "dados", cascade = CascadeType.ALL)
    private List<Book> results = new ArrayList<>();

    public Data() {}

    public Data(Long id , Integer count , String next , String previous , List<Book> results) {
        this.id = id;
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Book> getResults() {
        return results;
    }

    public void setResults(List<Book> results) {
        this.results = results;
    }

}
