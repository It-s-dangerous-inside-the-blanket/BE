package UMC_9th.AhanOn.domain.user.entity;

import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "users",
        indexes = {
                @Index(name = "ux_users_nickname", columnList = "nickname", unique = true)
        }
)
@Getter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "completed_book_count", nullable = false)
    @Builder.Default
    private int completedBookCount = 0;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @Builder.Default
    private List<Book> bookList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private UserLevel userLevel;

    public void addBook(Book book) {
        bookList.add(book);
        book.setUser(this);
    }

    public void increaseCompletedBookCount() {
        completedBookCount = this.completedBookCount + 1;
        this.userLevel = UserLevel.fromBookCount(completedBookCount);
    }
}
