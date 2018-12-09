package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.namedassign.ModifierAreaV14
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.namedassign.ModifierCableV14
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.namedassign.ModifierFrameV14
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.namedassign.ReleaseFrameV14

interface NamedAssignV14 : SapComponent {
    val modifierArea: ModifierAreaV14
    val modifierCable: ModifierCableV14
    val modifierFrame: ModifierFrameV14
    val releaseFrame: ReleaseFrameV14
}