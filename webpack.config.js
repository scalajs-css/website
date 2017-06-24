'use strict';

var webpack = require('webpack');
var path = require('path');
var NODE_ENV = process.env.NODE_ENV;
var WorkboxBuildWebpackPlugin = require('workbox-webpack-plugin');
module.exports = {

    entry: {
        mainpage: './index.web.js'
    },
    output: {
        path: __dirname + '/build',
        publicPath: "/build/",
        filename: '[name]-bundle.js'
    },
    plugins: [
        new webpack.DefinePlugin({
            'process.env': {
                'NODE_ENV': JSON.stringify('development')
            }
        })
        // new WorkboxBuildWebpackPlugin({
        //     globPatterns: ['**\/*.{html,js,css}'],
        //     globIgnores: ['admin.html'],
        //     swDest: './build/sw.js'
        // })
    ],
    devServer: {
        historyApiFallback: true,
        compress: true,
        port: 8090
    },
    module: {
        loaders: [

            {
                test: /\.json$/,
                loader: "json-loader"
            },

            {
                test: /\.css$/,
                loader: 'style-loader!css-loader'
            },
            {
                test: /\.woff(\?v=\d+\.\d+\.\d+)?$/,
                loader: "url-loader?limit=10000&mimetype=application/font-woff"
            }, {
                test: /\.woff2(\?v=\d+\.\d+\.\d+)?$/,
                loader: "url-loader?limit=10000&mimetype=application/font-woff"
            }, {
                test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/,
                loader: "url-loader?limit=10000&mimetype=application/octet-stream"
            }, {
                test: /\.eot(\?v=\d+\.\d+\.\d+)?$/,
                loader: "file-loader"
            },
            {
                test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
                loader: "url-loader?limit=10000&mimetype=image/svg+xml"
            },
            {
                test: /\.(png|jpg|svg)$/,
                loaders: [
                    'url-loader?limit=8192',
                    {
                        loader: 'image-webpack-loader',
                        query: {
                            optipng: {
                                optimizationLevel: 4,
                            },
                            mozjpeg: {
                                progressive: true,
                            }
                        }
                    }
                ]
            } // inline base64 URLs for <=8k images, direct URLs for the rest,

        ]
    }


};