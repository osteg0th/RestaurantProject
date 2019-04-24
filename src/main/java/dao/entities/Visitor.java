package dao.entities;

public class Visitor {
    private Integer id;
    private String name;
    private Integer table_id;

    public Visitor(Integer id, String name, Integer table_id) {
        this.id = id;
        this.name = name;
        this.table_id = table_id;
    }
    class Table{
        private Integer id;
        private boolean status;

        public Table(Integer id, boolean status) {
            this.id = id;
            this.status = status;
        }
    }
}
