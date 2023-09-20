package searchengine.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "search_index")
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "page_id", insertable = false, updatable = false)
    private Page page;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "lemma_id", insertable = false, updatable = false)
    private Lemma lemma;

    @Column(name = "rank_lemma", columnDefinition = "FLOAT")
    @NotNull
    private int rank;
}
