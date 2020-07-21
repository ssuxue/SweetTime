<template>
  <div id="app">
    <el-container style="border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu
          :default-openeds="['2']"
          :default-active="'fancyCoffee'"
          router
        >
          <div class="demo-fit">
            <div class="block">
              <el-avatar
                shape="square"
                :size="100"
                :fit="fit"
                :src="url"
              ></el-avatar>
            </div>
          </div>
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-milk-tea"></i>奶茶
            </template>
            <el-menu-item :index="'enjoyMilkTea'">纯享奶茶</el-menu-item>
            <el-menu-item :index="'sweetJuice'">甜蜜果汁</el-menu-item>
            <el-menu-item :index="'Sindy'">乐活果漾</el-menu-item>
            <el-menu-item :index="'doublePeelMilk'">双皮奶</el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-coffee"></i>咖啡
            </template>
            <el-menu-item :index="'blackCoffee'">黑咖啡</el-menu-item>
            <el-menu-item :index="'fancyCoffee'">花式咖啡</el-menu-item>
            <el-menu-item :index="'espresso'">意式咖啡</el-menu-item>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-goods"></i>订单
            </template>
            <el-menu-item index="3-1">未处理订单</el-menu-item>
            <el-menu-item index="3-2">已处理订单</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header
          style="text-align: right; font-size: 12px; background: #63cdda"
        >
          <div style="float:left;">
            <el-button @click="drawer = true" type="primary">管理</el-button>
          </div>
          <el-badge :value="12" :max="99" class="item">
            <el-button size="small">订单</el-button>
          </el-badge>
          <el-badge :value="180" :max="99" class="item" type="primary">
            <el-button size="small">评价</el-button>
          </el-badge>
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>顾林</span>
        </el-header>

        <el-main>
          <router-view />
        </el-main>
        <el-drawer title="管理功能" :visible.sync="drawer" :with-header="true">
          <div style="text-align: center; margin-bottom: 10px;">
            <el-button type="primary" plain @click="dialogVisible1 = true"
              >新增饮品</el-button
            >
            <el-button type="primary" plain>新增咖啡</el-button>
            <el-button type="danger" plain @click="dialogVisible = true"
              >删除饮品</el-button
            >
            <el-button type="danger" plain>删除咖啡</el-button>
          </div>
          <div style="text-align: center; margin-bottom: 10px;">
            <el-button type="primary" plain>查询饮品</el-button>
            <el-button type="primary" plain>查询咖啡</el-button>
            <el-button type="success" plain>查询会员</el-button>
            <el-button type="success" plain>查询订单</el-button>
          </div>
        </el-drawer>
      </el-container>

      <el-dialog
        title="删除奶茶"
        :visible.sync="dialogVisible"
        width="50%"
        :before-close="handleClose"
      >
        <div style="text-align: center">
          <el-transfer
            style="text-align: left; display: inline-block"
            v-model="value"
            filterable
            :render-content="renderFunc"
            :titles="['奶茶列表', '已选列表']"
            :button-texts="['到左边', '到右边']"
            :format="{
              noChecked: '${total}',
              hasChecked: '${checked}/${total}',
            }"
            @change="handleChange"
            :data="data"
          ></el-transfer>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="deleteMT">确 定</el-button>
        </span>
      </el-dialog>

      <el-dialog title="添加饮品" width="40%" :visible.sync="dialogVisible1">
        <el-form :model="drinks">
          <el-form-item label="饮品名称" :label-width="formLabelWidth">
            <el-input
              v-model="drinks.name"
              autocomplete="off"
              style="width:60%;"
            ></el-input>
          </el-form-item>
          <el-form-item label="饮品价格" :label-width="formLabelWidth">
            <el-input
              v-model="drinks.price"
              autocomplete="off"
              style="width:60%;"
            ></el-input>
          </el-form-item>
          <el-form-item label="饮品分类" :label-width="formLabelWidth">
            <el-select v-model="drinks.type" placeholder="请选择奶茶类别">
              <el-option label="纯享奶茶" value="1"></el-option>
              <el-option label="甜蜜果汁" value="2"></el-option>
              <el-option label="乐活果漾" value="3"></el-option>
              <el-option label="双皮奶" value="4"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible1 = false">取 消</el-button>
          <el-button type="primary" @click="addMT">确 定</el-button>
        </div>
      </el-dialog>
    </el-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      fit: 'fill',
      url: 'http://www.005.tv/uploads/allimg/200402/66-2004021K326138.png',
      drawer: false,
      dialogVisible: false,
      dialogVisible1: false,
      data: [],
      value: [],
      tableData: [],
      total: 0,
      renderFunc(h, option) {
        return (
          <span>
            {option.key} - {option.label}
          </span>
        )
      },
      drinks: {
        name: '',
        price: '',
        type: '',
      },
      formLabelWidth: '120px',
    }
  },
  methods: {
    tableRowClassName({ row, rowIndex }) {
      if (rowIndex % 2 === 1) {
        return 'success-row'
      }
      return ''
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then((_) => {
          done()
        })
        .catch((_) => {})
    },
    getMilkTea() {
      axios.get('http://localhost:8181/milktea/getAll').then((response) => {
        this.tableData = response.data.records
        this.total = response.data.total
        for (let i = 0; i < this.total; i++) {
          this.data.push({
            key: this.tableData[i].id,
            label: `${this.tableData[i].name}`,
          })
        }
      })
    },
    deleteMT() {
      this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(() => {
          axios
            .delete('http://localhost:8181/milktea/deleteByIds', {
              data: this.value,
            })
            .then((response) => {
              if (response.data === 'success') {
                this.$message({
                  message: '删除成功',
                  type: 'success',
                })
                this.timer = setInterval(() => {
                  this.$router.go(0)
                }, 1000)
              } else {
                this.$message.error('删除失败')
              }
            })
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除',
          })
        })
    },
    addMT() {
      axios
        .post('http://localhost:8181/milktea/save', this.drinks)
        .then((response) => {
          if (response.data === 'success') {
            this.$message({
              message: '添加成功',
              type: 'success',
            })
          } else {
            this.$message.error('添加失败')
          }
        })
    },
    getImgPath() {
      axios
        .get('http://localhost:8181/admin/getImgPath/' + '1101')
        .then((response) => {
          this.url = response.data
        })
    },
  },
  mounted() {
    this.getMilkTea()
    // this.getImgPath()
  },
}
</script>

<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}

html,
body,
#app,
.el-container {
  /*设置内部填充为0，几个布局元素之间没有间距*/
  padding: 0px;
  /*外部间距也是如此设置*/
  margin: 0px;
  /*统一设置高度为100%*/
  height: 100%;
}

.item {
  margin-top: 10px;
  margin-right: 40px;
}

.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>
