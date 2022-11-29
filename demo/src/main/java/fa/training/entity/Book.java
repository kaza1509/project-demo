package fa.training.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Book {
    private int bookId;
    private String bookName;
    private String authorName;
    private String publishDate;
}
