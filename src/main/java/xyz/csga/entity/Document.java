package xyz.csga.entity;

public class Document {
    private String file_id;
    private PhotoSize thumb;
    private String file_name;
    private String mine_type;
    private Integer file_size;

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(PhotoSize thumb) {
        this.thumb = thumb;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getMine_type() {
        return mine_type;
    }

    public void setMine_type(String mine_type) {
        this.mine_type = mine_type;
    }

    public Integer getFile_size() {
        return file_size;
    }

    public void setFile_size(Integer file_size) {
        this.file_size = file_size;
    }
}
