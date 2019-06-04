package controllers.TableCommands;

import entities.Table;
import service.TableService;

public abstract class TableCommand {
    Table table;
    TableService tableService = new TableService();
}
