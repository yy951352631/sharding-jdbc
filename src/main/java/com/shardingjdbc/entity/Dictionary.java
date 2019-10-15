package com.shardingjdbc.entity;

import javax.persistence.*;

/**
 * @author Wtq
 * @date 2019/10/14 - 10:37
 */
@Entity
@Table(name = "T_DICT")
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dict_id")
    private Long dictId;

    @Column(name = "type")
    private String type;

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private String value;

    public Dictionary(String type, String code, String value) {
        this.type = type;
        this.code = code;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dictId=" + dictId +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public Dictionary() {
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
