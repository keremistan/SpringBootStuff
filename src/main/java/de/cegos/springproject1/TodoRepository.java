package de.cegos.springproject1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface TodoRepository{
    public List<Todo> findAll();
}
