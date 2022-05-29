package com.aeviles.deliveryapi.noficacao;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)//diz quanto tempo deve permanecer onde foi usada, o runtime diz que ela pode ser lida em tempo de execução
public @interface TipoDoNotificador {

    NivelUrgencia value();


}
