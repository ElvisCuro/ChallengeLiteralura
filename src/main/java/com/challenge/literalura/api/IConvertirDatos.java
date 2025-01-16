package com.challenge.literalura.api;

public interface IConvertirDatos {

    <T> T obtenerDatos(String json , Class<T> clase); //metodo generico que coje el json y convierte en datos Java ya que no se sabe que retornara

}
