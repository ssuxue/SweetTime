<template>
  <div class="fancyCoffee">
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="id" label="编号" width="180"></el-table-column>
      <el-table-column prop="name" label="名称" width="180"></el-table-column>
      <el-table-column prop="price" label="价格"></el-table-column>
      <el-table-column fixed="right" label="操作" width="180">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">添加</el-button>
          <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="edit(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="pageSize"
      :total="total"
      @current-change="page"
    ></el-pagination>
  </div>
</template>

<script>
export default {
  name: "fancyCoffee",
  data() {
    return {
      tableData: [],
      pageSize: 8,
      total: 0
    };
  },
  components: {},
  created() {},
  mounted() {
    this.selectPageOne();
  },
  methods: {
    page(currentPage) {
      axios
        .get(
          "http://localhost:8181/coffee/getCoffeeByType/" + currentPage + "/8/2"
        )
        .then(response => {
          this.tableData = response.data.records;
          this.total = response.data.total;
        });
    },
    selectPageOne() {
      axios
        .get("http://localhost:8181/coffee/getCoffeeByType/1/8/2")
        .then(response => {
          this.tableData = response.data.records;
          this.total = response.data.total;
        });
    }
  }
};
</script>
<style lang='scss' scoped>
</style>
