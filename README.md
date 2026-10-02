# PDI Java: POO com a classe Usuario

Projeto de estudo para consolidar a sintaxe de Java e os 4 pilares da
Programação Orientada a Objetos.

## Objetivo

Base da linguagem para avançar para Spring Boot.

## Pilares aplicados

| Pilar          | Onde aparece                                              |
|----------------|-----------------------------------------------------------|
| Abstração      | `Usuario` modela nome, e-mail, senha e status             |
| Encapsulamento | Atributos `private`, setters com validação, sem `getSenha`|
| Herança        | `UsuarioAdmin extends Usuario`                            |
| Polimorfismo   | `getPerfil()` sobrescrito em `UsuarioAdmin`               |

## Estrutura

```
src/br/com/eduardo/usuarios/
├── Main.java
└── modelo/
    ├── Usuario.java
    └── UsuarioAdmin.java
```

## Como executar

```bash
javac -d out (Get-ChildItem -Recurse -Filter *.java src).FullName
java -cp out/production/pdi-poo-java br.com.eduardo.usuarios.Main
```

## Saída esperada

```
Eduardo | edu@email.com | CLIENTE | ativo
Maria | maria@email.com | ADMIN (nível 2) | ativo
true
false
false
Erro esperado: O nome não pode ser vazio.
```