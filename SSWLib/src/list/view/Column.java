
package list.view;

import javax.swing.SortOrder;


public class Column {
    public int Index = 0;
    public String Title = "";
    public boolean isEditable = false;
    public int preferredWidth = 0;
    public Class classType = String.class;
    public boolean isSortable = false;
    public SortOrder sortOrder = null;
    public String propertyName = "";

    public Column( int Index, String Title, String propertyName ) {
        this(Index, Title, propertyName, false, 0, String.class, false, null);
    }

    public Column( int Index, String Title, String propertyName, int PreferredWidth ) {
        this(Index, Title, propertyName, false, PreferredWidth, String.class, false, null);
    }

    public Column( int Index, String Title, String propertyName, boolean isEditable ) {
        this(Index, Title, propertyName, isEditable, 0, String.class, false, null);
    }

    public Column( int Index, String Title, String propertyName, int PreferredWidth, boolean isEditable ) {
        this(Index, Title, propertyName, isEditable, PreferredWidth, String.class, false, null);
    }

    public Column( int Index, String Title, String propertyName, int PreferredWidth, boolean isEditable, Class ClassType ) {
        this(Index, Title, propertyName, isEditable, PreferredWidth, ClassType, false, null);
    }

    public Column( int Index, String Title, String propertyName, int PreferredWidth, Class ClassType ) {
        this(Index, Title, propertyName, false, PreferredWidth, ClassType, false, null);
    }

    public Column( int Index, String Title, String propertyName, boolean isEditable, int PreferredWidth, Class ClassType, boolean Sortable, SortOrder sortOrder ) {
        this.Index = Index;
        this.Title = Title;
        this.propertyName = propertyName;
        this.isEditable = isEditable;
        this.preferredWidth = PreferredWidth;
        this.classType = ClassType;
        this.isSortable = Sortable;
        this.sortOrder = sortOrder;
    }
}
