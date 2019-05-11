package com.lambdaschool.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class ToDo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false)
    private String tododescription;

    private String datestarted;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties({"toDos", "hibernateLazyInitializer"})
    private User user;

    public ToDo()
    {
    }

    public ToDo(String tododescription, String datestarted, User user)
    {
        this.tododescription = tododescription;
        this.datestarted = datestarted;
        this.user = user;
        this.completed = false;
    }


    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getTododescription()
    {
        return tododescription;
    }

    public void setTododescription(String tododescription)
    {
        this.tododescription = tododescription;
    }

    public String getDatestarted()
    {
        return datestarted;
    }

    public void setDatestarted(String datestarted)
    {
        this.datestarted = datestarted;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
