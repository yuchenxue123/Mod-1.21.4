package com.yuchenxue.module.movement

import com.yuchenxue.module.ClientModule
import com.yuchenxue.module.ModuleCategory
import com.yuchenxue.utils.client.ModuleInfo
import com.yuchenxue.utils.value.IntLimitProperty
import com.yuchenxue.utils.value.IntValue

/**
 * @author yuchenxue
 * @date 2025/01/13 - 13:37
 */

@ModuleInfo("InvMove", ModuleCategory.MOVEMENT, "Move when has screen.")
object ModuleInvMove : ClientModule() {

    @IntValue("Tick", 0, 5)
    private var tick by IntLimitProperty(0, 5, 0)
}