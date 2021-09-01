package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class Controller {

    @GetMapping(path = "{dia}/{mes}/{ano}")
    public int IdadeDaPessoa(@PathVariable Integer dia,@PathVariable Integer mes, @PathVariable Integer ano){

        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(Calendar.YEAR,ano);
        dataNascimento.set(Calendar.MONTH, mes-1);
        dataNascimento.set(Calendar.DAY_OF_MONTH, dia);

        Calendar hoje = Calendar.getInstance();

        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            idade--;
        }
        else
        {
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }

        return idade;


    }


}
