/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.cartao.aml.domain;

public class Compra {

  private String cpf;
  private String local;
  private float valor;

  private boolean processed;

  public Compra() {
  }

  public Compra(String cpf, String local, float valor, boolean processed) {
    this.cpf = cpf;
    this.local = local;
    this.valor = valor;
    this.processed = processed;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getLocal() {
    return this.local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public float getValor() {
    return this.valor;
  }

  public void setValor(float valor) {
    this.valor = valor;
  }

  public boolean isProcessed() {
    return this.processed;
  }

  public boolean getProcessed() {
    return this.processed;
  }

  public void setProcessed(boolean processed) {
    this.processed = processed;
  }

  @Override
  public String toString() {
    return "{" +
      " cpf='" + getCpf() + "'" +
      ", local='" + getLocal() + "'" +
      ", valor='" + getValor() + "'" +
      ", processed='" + isProcessed() + "'" +
      "}";
  }


}
