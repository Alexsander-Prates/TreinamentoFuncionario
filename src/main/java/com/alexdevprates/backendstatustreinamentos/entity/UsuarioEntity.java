

public class UsuarioEntity{

    public UsuarioEntity(){

    }

    private Long id;

    private String name;

    private String email;

    private Strign senha;

    private String setor;

    private String cargo;


     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }




}