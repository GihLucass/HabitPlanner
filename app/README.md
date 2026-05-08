# Habit Planner 📋

Aplicativo Android desenvolvido em Kotlin para gerenciar hábitos diários.

---

## 📱 Proposta do Aplicativo

O **Habit Planner** é um planejador de hábitos simples que permite ao usuário:
- Visualizar uma lista de hábitos cadastrados
- Marcar hábitos como concluídos
- Adicionar novos hábitos

---

## 📚 Pesquisa dos Conceitos

### 1. Bottom Navigation

O **Bottom Navigation** é um componente de navegação posicionado na parte inferior da tela. Ele permite ao usuário navegar entre as principais seções do aplicativo de forma rápida e intuitiva.

No projeto, a Bottom Navigation é usada para alternar entre dois Fragments:
- **Hábitos** (HomeFragment): lista os hábitos cadastrados
- **Adicionar** (AddHabitFragment): formulário para criar novos hábitos

```xml
<com.google.android.material.bottomnavigation.BottomNavigationView
    android:id="@+id/bottomNavigationView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:menu="@menu/bottom_nav_menu" />
```

---

### 2. Classe de Dados (data class)

Uma **data class** em Kotlin é uma classe criada especialmente para armazenar dados. Ao usar a palavra-chave `data`, o Kotlin gera automaticamente métodos úteis como `equals()`, `hashCode()`, `toString()` e `copy()`.

No projeto, a entidade `Habit` é uma data class:

```kotlin
data class Habit(
    val id: Int,
    val nome: String,
    val descricao: String,
    val feito: Boolean = false
)
```

Isso evita escrever muito código repetitivo, como seria necessário em Java.

---

### 3. Entidade

Uma **entidade** representa um objeto do mundo real dentro do aplicativo. No contexto Android (especialmente com banco de dados Room), uma entidade define a estrutura de uma tabela. Mesmo sem usar banco de dados, o conceito de entidade é usado para modelar os dados do sistema.

No projeto, a entidade é `Habit`, que representa um hábito com: ID, nome, descrição e se foi concluído.

---

### 4. RecyclerView

O **RecyclerView** é um componente que exibe listas de forma eficiente. Ele "recicla" as views que saem da tela para reutilizá-las nos novos itens, economizando memória.

É composto por três partes:
- **RecyclerView**: exibido no layout XML
- **Adapter**: conecta os dados com as views dos itens
- **ViewHolder**: guarda as referências de cada view de um item

No projeto, o `HabitAdapter` faz essa conexão entre a lista de `Habit` e o layout `item_habit.xml`.

---

### 5. Fragment

Um **Fragment** é uma parte da interface do usuário que pode ser inserida dentro de uma Activity. Ele tem seu próprio ciclo de vida e layout, e permite dividir a tela em partes modulares e reutilizáveis.

No projeto há dois Fragments:
- `HomeFragment`: tela com a lista de hábitos
- `AddHabitFragment`: tela para adicionar novos hábitos

A troca de Fragments é feita pelo `FragmentManager` na `MainActivity`.

---

### 6. Ciclo de Vida

O **ciclo de vida** define os estados pelos quais uma Activity ou Fragment passa durante sua existência.

Principais métodos da Activity:
| Método       | Quando é chamado                         |
|--------------|------------------------------------------|
| `onCreate`   | Ao criar pela primeira vez               |
| `onStart`    | Quando a tela fica visível               |
| `onResume`   | Quando o usuário pode interagir          |
| `onPause`    | Quando perde o foco (mas ainda visível)  |
| `onStop`     | Quando a tela fica invisível             |
| `onDestroy`  | Quando a Activity é destruída            |

No projeto, todos esses métodos estão implementados na `MainActivity`, `HomeFragment` e `AddHabitFragment`, com `Log.d("CicloDeVida", ...)` para observar no Logcat do Android Studio.

---

## 🗂 Estrutura do Projeto

```
app/
├── adapter/
│   └── HabitAdapter.kt       → Adaptador do RecyclerView
├── data/
│   └── HabitRepository.kt    → Fonte de dados (lista em memória)
├── fragment/
│   ├── HomeFragment.kt        → Tela principal com a lista
│   └── AddHabitFragment.kt   → Tela de adicionar hábito
├── model/
│   └── Habit.kt              → Entidade / data class
└── MainActivity.kt           → Activity com Bottom Navigation
```

---

## 🚀 Como executar

1. Abra o projeto no **Android Studio**
2. Aguarde o Gradle sincronizar
3. Conecte um emulador ou dispositivo físico
4. Clique em **Run ▶**
5. Para ver o ciclo de vida: abra o **Logcat** e filtre por `CicloDeVida`
