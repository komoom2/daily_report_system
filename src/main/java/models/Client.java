package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = JpaConst.TABLE_CLI)
@NamedQueries({
        @NamedQuery(
                        name = JpaConst.Q_CLI_GET_ALL,
                        query = JpaConst.Q_CLI_GET_ALL_DEF),
        @NamedQuery(
                        name = JpaConst.Q_CLI_COUNT,
                        query = JpaConst.Q_CLI_COUNT_DEF)
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {
    @Id
    @Column(name = JpaConst.CLI_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = JpaConst.CLI_COL_NAME, nullable = false)
    private String name;

    @Column(name = JpaConst.CLI_COL_ADDRESS)
    private String address;

    @Column(name = JpaConst.CLI_COL_PHONE_NUMBER)
    private String phoneNumber;

    @Column(name = JpaConst.CLI_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = JpaConst.CLI_COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = JpaConst.CLI_COL_DELETE_FLAG, nullable = false)
    private Integer deleteFlag;

}
