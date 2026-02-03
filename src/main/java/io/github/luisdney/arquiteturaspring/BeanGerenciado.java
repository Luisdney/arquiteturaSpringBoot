package io.github.luisdney.arquiteturaspring;

import io.github.luisdney.arquiteturaspring.todos.TodoEntity;
import io.github.luisdney.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Lazy(false)
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Scope("request")
//@Scope("session")
//@Scope("application")
public class BeanGerenciado {
    private String idUsuarioLogado;

    @Autowired
    private TodoValidator validator;


    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    @Autowired
    public void setValidator(TodoValidator validator){
        this.validator = validator;
    }

}
