package com.kirina.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName book
 */
@TableName(value ="book")
@Data
public class Book implements Serializable {
    /**
     *
     */
    @TableId
    private String isbn;

    /**
     *
     */
    private String title;

    /**
     *
     */
    private String author;

    /**
     *
     */
    @TableLogic
    private Integer deleted;

    /**
     *
     */
    @Version
    private Integer version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Book other = (Book) that;
        return (this.getIsbn() == null ? other.getIsbn() == null : this.getIsbn().equals(other.getIsbn()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", isbn=").append(isbn);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", deleted=").append(deleted);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
