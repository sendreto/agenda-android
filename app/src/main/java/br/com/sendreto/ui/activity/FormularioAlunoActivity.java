package br.com.sendreto.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.sendreto.R;
import br.com.sendreto.dao.AlunoDao;
import br.com.sendreto.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo Aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private final AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);

        inicializacaoDosCampos();

        configuraBotaoSalvar();
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.acitivity_formulario_aluno_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno alunoCriado = criaAluno();
                salva(alunoCriado);
            }
        });
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.acitivity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.acitivity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.acitivity_formulario_aluno_email);
    }

    private void salva(Aluno aluno) {
        dao.salva(aluno);
        finish();
    }

    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();
        return new Aluno(nome, telefone, email);
    }
}
