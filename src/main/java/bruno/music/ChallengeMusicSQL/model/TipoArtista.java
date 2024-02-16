package bruno.music.ChallengeMusicSQL.model;

public enum TipoArtista {
    //enum
    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");

    private String tipo;
    TipoArtista(String tipo) {
        this.tipo = tipo;
    }

    //fromString é nome do metodo
    public static TipoArtista fromString(String text){
        for (TipoArtista tipoArtista : TipoArtista.values()){
            if(tipoArtista.tipo.equalsIgnoreCase(text)){
                return tipoArtista;
            }
        }
        throw new IllegalArgumentException("tipo invalido" + text);
    }

}
