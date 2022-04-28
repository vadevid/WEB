module.exports = {
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:9999/',
        changeOrigin: true,
        pathRewrite: {
          '^/api': '',
        },
      },
    },
  },
};
