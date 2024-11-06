<script>
    export default {
      name:"Header",
      methods:{
        toUser(){
          console.log('to_user')
        },
        logout(){
          console.log('logout')
        }
      }

    }
</script>

<template>
  <div style="display: flex;">
    <div style="flex: 1;text-align: center;font-size: 30px;">
      <span>欢迎来到登录系统</span>
    </div>
    <el-dropdown>
      <span>id</span><i class="el-icon-setting" style="margin-left: 5px;"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item @click.native="toUser">个人信息</el-dropdown-item>
        <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<style scoped>

</style>