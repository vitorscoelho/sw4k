package vitorscoelho.sw4k.sap14.enums

enum class ItemType(val value: Byte) {
    /**
     * The assignment is made to the frame object specified by the Name item.
     */
    OBJECT(0),

    /**
     * The assignment is made to all frame objects in the group specified by the Name item.
     */
    GROUP(1),

    /**
     * The assignment is made to all selected frame objects and the Name item is ignored.
     */
    SELECTED_OBJECTS(2)
}