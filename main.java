<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Digital Wellbeing Monitor</title>
    <style>
        :root {
            --bg-primary: #121212;
            --bg-secondary: #1e1e1e;
            --bg-tertiary: #2d2d2d;
            --text-primary: #ffffff;
            --text-secondary: #b3b3b3;
            --accent-primary: #7e57c2;
            --accent-secondary: #5e35b1;
            --warning: #ff5722;
            --success: #4caf50;
            --info: #2196f3;
            --danger: #f44336;
            --border-radius: 8px;
            --shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            --transition: all 0.3s ease;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background-color: var(--bg-primary);
            color: var(--text-primary);
            line-height: 1.6;
            overflow-x: hidden;
        }

        .container {
            display: grid;
            grid-template-columns: 250px 1fr;
            grid-template-rows: 70px 1fr;
            grid-template-areas: 
                "sidebar header"
                "sidebar main";
            height: 100vh;
        }

        /* Header styles */
        header {
            grid-area: header;
            background-color: var(--bg-secondary);
            padding: 0 2rem;
            display: flex;
            align-items: center;
            justify-content: space-between;
            box-shadow: var(--shadow);
            z-index: 10;
        }

        .search-bar {
            position: relative;
            width: 300px;
        }

        .search-bar input {
            width: 100%;
            padding: 10px 15px;
            padding-left: 40px;
            border: none;
            border-radius: var(--border-radius);
            background-color: var(--bg-tertiary);
            color: var(--text-primary);
            font-size: 14px;
        }

        .search-bar i {
            position: absolute;
            left: 15px;
            top: 50%;
            transform: translateY(-50%);
            color: var(--text-secondary);
        }

        .user-profile {
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .user-profile img {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            object-fit: cover;
        }

        .user-profile span {
            font-weight: 600;
        }

        /* Sidebar styles */
        .sidebar {
            grid-area: sidebar;
            background-color: var(--bg-secondary);
            padding: 2rem 0;
            display: flex;
            flex-direction: column;
            box-shadow: var(--shadow);
            z-index: 5;
        }

        .logo {
            padding: 0 2rem;
            margin-bottom: 2rem;
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .logo img {
            width: 40px;
            height: 40px;
        }

        .logo h1 {
            font-size: 1.2rem;
            font-weight: 700;
            color: var(--accent-primary);
        }

        .nav-links {
            display: flex;
            flex-direction: column;
            gap: 5px;
        }

        .nav-link {
            display: flex;
            align-items: center;
            gap: 15px;
            padding: 12px 2rem;
            color: var(--text-secondary);
            text-decoration: none;
            transition: var(--transition);
            border-left: 3px solid transparent;
        }

        .nav-link:hover, .nav-link.active {
            background-color: var(--bg-tertiary);
            color: var(--text-primary);
            border-left-color: var(--accent-primary);
        }

        .nav-link i {
            font-size: 1.2rem;
        }

        /* Main content styles */
        main {
            grid-area: main;
            padding: 2rem;
            overflow-y: auto;
        }

        .section-header {
            margin-bottom: 1.5rem;
        }

        .section-header h2 {
            font-size: 1.8rem;
            font-weight: 600;
            margin-bottom: 0.5rem;
        }

        .section-header p {
            color: var(--text-secondary);
        }

        .dashboard-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 1.5rem;
            margin-bottom: 2rem;
        }

        .card {
            background-color: var(--bg-secondary);
            border-radius: var(--border-radius);
            padding: 1.5rem;
            box-shadow: var(--shadow);
            transition: var(--transition);
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
        }

        .card-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 1rem;
        }

        .card-header h3 {
            font-size: 1.2rem;
            font-weight: 600;
        }

        .card-header .icon {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            background-color: var(--accent-primary);
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
        }

        .card-body {
            margin-bottom: 1rem;
        }

        .card-value {
            font-size: 2rem;
            font-weight: 700;
            margin-bottom: 0.5rem;
        }

        .card-trend {
            display: flex;
            align-items: center;
            gap: 5px;
            font-size: 0.9rem;
        }

        .trend-up {
            color: var(--danger);
        }

        .trend-down {
            color: var(--success);
        }

        .chart-container {
            width: 100%;
            height: 200px;
        }

        /* Charts section */
        .charts-row {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 1.5rem;
            margin-bottom: 2rem;
        }

        .chart-card {
            background-color: var(--bg-secondary);
            border-radius: var(--border-radius);
            padding: 1.5rem;
            box-shadow: var(--shadow);
        }

        .chart-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 1rem;
        }

        .chart-header h3 {
            font-size: 1.2rem;
            font-weight: 600;
        }

        .chart-header select {
            padding: 5px 10px;
            border-radius: 5px;
            background-color: var(--bg-tertiary);
            color: var(--text-primary);
            border: none;
        }

        /* Health metrics section */
        .health-metrics {
            background-color: var(--bg-secondary);
            border-radius: var(--border-radius);
            padding: 1.5rem;
            box-shadow: var(--shadow);
            margin-bottom: 2rem;
        }

        .metrics-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 1.5rem;
        }

        .metrics-header h3 {
            font-size: 1.2rem;
            font-weight: 600;
        }

        .metrics-header .date-range {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .date-range button {
            padding: 5px 10px;
            border-radius: 5px;
            background-color: var(--bg-tertiary);
            color: var(--text-primary);
            border: none;
            cursor: pointer;
            transition: var(--transition);
        }

        .date-range button.active {
            background-color: var(--accent-primary);
        }

        .metrics-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            gap: 1rem;
        }

        .metric-item {
            background-color: var(--bg-tertiary);
            border-radius: var(--border-radius);
            padding: 1rem;
            text-align: center;
        }

        .metric-icon {
            width: 50px;
            height: 50px;
            border-radius: 50%;
            margin: 0 auto 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 1.5rem;
        }

        .sleep .metric-icon {
            background-color: rgba(33, 150, 243, 0.2);
            color: var(--info);
        }

        .physical .metric-icon {
            background-color: rgba(76, 175, 80, 0.2);
            color: var(--success);
        }

        .mental .metric-icon {
            background-color: rgba(126, 87, 194, 0.2);
            color: var(--accent-primary);
        }

        .screen .metric-icon {
            background-color: rgba(255, 87, 34, 0.2);
            color: var(--warning);
        }

        .metric-value {
            font-size: 1.5rem;
            font-weight: 700;
            margin-bottom: 5px;
        }

        .metric-label {
            color: var(--text-secondary);
            font-size: 0.9rem;
        }

        /* Recommendations section */
        .recommendations {
            background-color: var(--bg-secondary);
            border-radius: var(--border-radius);
            padding: 1.5rem;
            box-shadow: var(--shadow);
        }

        .recommendations h3 {
            font-size: 1.2rem;
            font-weight: 600;
            margin-bottom: 1rem;
        }

        .recommendation-list {
            display: flex;
            flex-direction: column;
            gap: 1rem;
        }

        .recommendation-item {
            display: flex;
            gap: 15px;
            background-color: var(--bg-tertiary);
            border-radius: var(--border-radius);
            padding: 1rem;
            transition: var(--transition);
        }

        .recommendation-item:hover {
            transform: translateX(5px);
        }

        .recommendation-icon {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            background-color: rgba(126, 87, 194, 0.2);
            color: var(--accent-primary);
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 1.2rem;
        }

        .recommendation-content h4 {
            font-size: 1rem;
            font-weight: 600;
            margin-bottom: 5px;
        }

        .recommendation-content p {
            color: var(--text-secondary);
            font-size: 0.9rem;
        }

        /* Responsive styles */
        @media (max-width: 992px) {
            .container {
                grid-template-columns: 1fr;
                grid-template-areas: 
                    "header"
                    "main";
            }

            .sidebar {
                display: none;
            }

            .charts-row {
                grid-template-columns: 1fr;
            }
        }

        @media (max-width: 768px) {
            header {
                padding: 0 1rem;
            }

            .search-bar {
                display: none;
            }

            main {
                padding: 1rem;
            }

            .dashboard-grid {
                grid-template-columns: 1fr;
            }
        }

        /* Custom scrollbar */
        ::-webkit-scrollbar {
            width: 8px;
        }

        ::-webkit-scrollbar-track {
            background: var(--bg-primary);
        }

        ::-webkit-scrollbar-thumb {
            background: var(--bg-tertiary);
            border-radius: 10px;
        }

        ::-webkit-scrollbar-thumb:hover {
            background: var(--accent-primary);
        }

        /* Progress bars */
        .progress-bar {
            height: 8px;
            background-color: var(--bg-tertiary);
            border-radius: 4px;
            overflow: hidden;
            margin-top: 5px;
        }

        .progress {
            height: 100%;
            border-radius: 4px;
            transition: width 0.5s ease;
        }

        .progress-high {
            background-color: var(--danger);
        }

        .progress-medium {
            background-color: var(--warning);
        }

        .progress-low {
            background-color: var(--success);
        }

        /* Notification badge */
        .notification-badge {
            position: relative;
            cursor: pointer;
        }

        .badge {
            position: absolute;
            top: -5px;
            right: -5px;
            width: 18px;
            height: 18px;
            border-radius: 50%;
            background-color: var(--danger);
            color: white;
            font-size: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        /* Buttons */
        .btn {
            padding: 8px 16px;
            border-radius: var(--border-radius);
            border: none;
            cursor: pointer;
            transition: var(--transition);
            font-weight: 500;
        }

        .btn-primary {
            background-color: var(--accent-primary);
            color: white;
        }

        .btn-primary:hover {
            background-color: var(--accent-secondary);
        }

        .btn-secondary {
            background-color: var(--bg-tertiary);
            color: var(--text-primary);
        }

        .btn-secondary:hover {
            background-color: var(--bg-primary);
        }

        /* Tabs */
        .tabs {
            display: flex;
            gap: 10px;
            margin-bottom: 1.5rem;
        }

        .tab {
            padding: 8px 16px;
            border-radius: var(--border-radius);
            background-color: var(--bg-tertiary);
            color: var(--text-secondary);
            cursor: pointer;
            transition: var(--transition);
        }

        .tab.active {
            background-color: var(--accent-primary);
            color: white;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <div class="logo">
                <i class="fas fa-laptop-medical" style="color: var(--accent-primary); font-size: 1.8rem;"></i>
                <h1>DigitalWell</h1>
            </div>
            <nav class="nav-links">
                <a href="#" class="nav-link active">
                    <i class="fas fa-chart-line"></i>
                    <span>Dashboard</span>
                </a>
                <a href="#" class="nav-link">
                    <i class="fas fa-mobile-alt"></i>
                    <span>Screen Time</span>
                </a>
                <a href="#" class="nav-link">
                    <i class="fas fa-heartbeat"></i>
                    <span>Health Metrics</span>
                </a>
                <a href="#" class="nav-link">
                    <i class="fas fa-brain"></i>
                    <span>Mental Wellness</span>
                </a>
                <a href="#" class="nav-link">
                    <i class="fas fa-running"></i>
                    <span>Physical Activity</span>
                </a>
                <a href="#" class="nav-link">
                    <i class="fas fa-chart-pie"></i>
                    <span>Reports</span>
                </a>
                <a href="#" class="nav-link">
                    <i class="fas fa-lightbulb"></i>
                    <span>Recommendations</span>
                </a>
                <a href="#" class="nav-link">
                    <i class="fas fa-cog"></i>
                    <span>Settings</span>
                </a>
                <a href="#" class="nav-link">
                    <i class="fas fa-question-circle"></i>
                    <span>Help & Support</span>
                </a>
            </nav>
        </aside>

        <!-- Header -->
        <header>
            <div class="search-bar">
                <i class="fas fa-search"></i>
                <input type="text" placeholder="Search...">
            </div>
            <div class="user-profile">
                <div class="notification-badge">
                    <i class="fas fa-bell" style="font-size: 1.2rem;"></i>
                    <span class="badge">3</span>
                </div>
                <img src="/api/placeholder/40/40" alt="User Profile">
                <span>Krishna Sri G</span>
            </div>
        </header>

        <!-- Main Content -->
        <main>
            <div class="section-header">
                <h2>Digital Wellbeing Dashboard</h2>
                <p>Monitor your digital consumption and its impact on your overall well-being</p>
            </div>

            <!-- Dashboard Summary Cards -->
            <div class="dashboard-grid">
                <div class="card">
                    <div class="card-header">
                        <h3>Total Screen Time</h3>
                        <div class="icon">S
                            <i class="fas fa-desktop"></i>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="card-value">5h 35m</div>
                        <div class="card-trend trend-up">
                            <i class="fas fa-arrow-up"></i>
                            <span>12% from yesterday</span>
                        </div>
                    </div>
                    <div class="progress-bar">
                        <div class="progress progress-high" style="width: 78%;"></div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header">
                        <h3>Social Media Usage</h3>
                        <div class="icon">
                            <i class="fas fa-hashtag"></i>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="card-value">2h 15m</div>
                        <div class="card-trend trend-up">
                            <i class="fas fa-arrow-up"></i>
                            <span>8% from yesterday</span>
                        </div>
                    </div>
                    <div class="progress-bar">
                        <div class="progress progress-medium" style="width: 65%;"></div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header">
                        <h3>Sleep Quality</h3>
                        <div class="icon">
                            <i class="fas fa-moon"></i>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="card-value">6.5 hrs</div>
                        <div class="card-trend trend-down">
                            <i class="fas fa-arrow-down"></i>
                            <span>15% from yesterday</span>
                        </div>
                    </div>
                    <div class="progress-bar">
                        <div class="progress progress-medium" style="width: 60%;"></div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header">
                        <h3>Physical Activity</h3>
                        <div class="icon">
                            <i class="fas fa-walking"></i>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="card-value">3,245</div>
                        <div class="card-trend trend-down">
                            <i class="fas fa-arrow-down"></i>
                            <span>5% from yesterday</span>
                        </div>
                    </div>
                    <div class="progress-bar">
                        <div class="progress progress-low" style="width: 40%;"></div>
                    </div>
                </div>
            </div>

            <!-- Charts Section -->
            <div class="charts-row">
                <div class="chart-card">
                    <div class="chart-header">
                        <h3>Digital Consumption Trends</h3>
                        <select id="timeRangeSelector">
                            <option value="day">Today</option>
                            <option value="week" selected>This Week</option>
                            <option value="month">This Month</option>
                        </select>
                    </div>
                    <div class="chart-container" id="consumptionChart"></div>
                </div>

                <div class="chart-card">
                    <div class="chart-header">
                        <h3>App Usage Breakdown</h3>
                        <select id="appCategorySelector">
                            <option value="all" selected>All Categories</option>
                            <option value="social">Social</option>
                            <option value="productivity">Productivity</option>
                            <option value="entertainment">Entertainment</option>
                        </select>
                    </div>
                    <div class="chart-container" id="appUsageChart"></div>
                </div>
            </div>

            <!-- Health Metrics Section -->
            <div class="health-metrics">
                <div class="metrics-header">
                    <h3>Health Metrics Overview</h3>
                    <div class="date-range">
                        <button>Day</button>
                        <button class="active">Week</button>
                        <button>Month</button>
                    </div>
                </div>
                <div class="metrics-grid">
                    <div class="metric-item sleep">
                        <div class="metric-icon">
                            <i class="fas fa-bed"></i>
                        </div>
                        <div class="metric-value">6.5 hrs</div>
                        <div class="metric-label">Avg. Sleep Duration</div>
                    </div>
                    <div class="metric-item physical">
                        <div class="metric-icon">
                            <i class="fas fa-running"></i>
                        </div>
                        <div class="metric-value">4,528</div>
                        <div class="metric-label">Avg. Daily Steps</div>
                    </div>
                    <div class="metric-item mental">
                        <div class="metric-icon">
                            <i class="fas fa-brain"></i>
                        </div>
                        <div class="metric-value">65%</div>
                        <div class="metric-label">Mental Wellness Score</div>
                    </div>
                    <div class="metric-item screen">
                        <div class="metric-icon">
                            <i class="fas fa-mobile-alt"></i>
                        </div>
                        <div class="metric-value">4.8 hrs</div>
                        <div class="metric-label">Avg. Daily Screen Time</div>
                    </div>
                </div>
            </div>

            <!-- Recommendations Section -->
            <div class="recommendations">
                <h3>Personalized Recommendations</h3>
                <div class="recommendation-list">
                    <div class="recommendation-item">
                        <div class="recommendation-icon">
                            <i class="fas fa-moon"></i>
                        </div>
                        <div class="recommendation-content">
                            <h4>Improve Sleep Quality</h4>
                            <p>Try reducing screen time 1 hour before bed. Your late night usage has increased by 22% this week.</p>
                        </div>
                    </div>
                    <div class="recommendation-item">
                        <div class="recommendation-icon">
                            <i class="fas fa-walking"></i>
                        </div>
                        <div class="recommendation-content">
                            <h4>Increase Physical Activity</h4>
                            <p>Consider taking a 10-minute walk after every hour of screen time to meet your daily goal of 8,000 steps.</p>
                        </div>
                    </div>
                    <div class="recommendation-item">
                        <div class="recommendation-icon">
                            <i class="fas fa-brain"></i>
                        </div>
                        <div class="recommendation-content">
                            <h4>Reduce Social Media Stress</h4>
                            <p>Your mood score tends to decrease after prolonged social media use. Try setting a 30-minute daily limit.</p>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js"></script>
    <script>
        // Initialize charts when DOM is loaded
        document.addEventListener('DOMContentLoaded', function() {
            // Digital Consumption Trends Chart
            const consumptionCtx = document.getElementById('consumptionChart').getContext('2d');
            const consumptionChart = new Chart(consumptionCtx, {
                type: 'line',
                data: {
                    labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                    datasets: [
                        {
                            label: 'Screen Time (hrs)',
                            data: [4.2, 5.1, 4.8, 5.5, 6.2, 5.8, 4.5],
                            borderColor: '#7e57c2',
                            backgroundColor: 'rgba(126, 87, 194, 0.1)',
                            tension: 0.4,
                            fill: true
                        },
                        {
                            label: 'Social Media (hrs)',
                            data: [2.1, 2.4, 2.2, 2.8, 3.0, 2.5, 2.0],
                            borderColor: '#ff5722',
                            backgroundColor: 'rgba(255, 87, 34, 0.1)',
                            tension: 0.4,
                            fill: true
                        }
                    ]
                },
                options: {
                    responsive: true,
                    maintainAspectRatio: false,
                    plugins: {
                        legend: {
                            position: 'top',
                            labels: {
                                color: '#b3b3b3'
                            }
                        }
                    },
                    scales: {
                        x: {
                            grid: {
                                color: 'rgba(255, 255, 255, 0.05)'
                            },
                            ticks: {
                                color: '#b3b3b3'
                            }
                        },
                        y: {
                            grid: {
                                color: 'rgba(255, 255, 255, 0.05)'
                            },
                            ticks: {
                                color: '#b3b3b3'
                            }
                        }
                    }
                }
            });

            // App Usage Breakdown Chart
            const appUsageCtx = document.getElementById('appUsageChart').getContext('2d');
            const appUsageChart = new Chart(appUsageCtx, {
                type: 'doughnut',
                data: {
                    labels: ['Social Media', 'Entertainment', 'Productivity', 'Communication', 'Other'],
                    datasets: [{
                        data: [35, 25, 20, 15, 5],
                        backgroundColor: [
                            '#7e57c2',
                            '#ff5722',
                            '#4caf50',
                            '#2196f3',
                            '#9e9e9e'
                        ],
                        borderWidth: 0
                    }]
                },
                options: {
                    responsive: true,
                    maintainAspectRatio: false,
                    plugins: {
                        legend: {
                            position: 'right',
                            labels: {
                                color: '#b3b3b3',
                                padding: 15
                            }
                        }
                    }
                }
            });

            // Simulate real-time data updates
            setInterval(() => {
                // Update screen time with small random variations
                const screenTimeEl = document.querySelector('.card:nth-child(1) .card-value');
                let hours = parseInt(screenTimeEl.textContent.split('h')[0]);
                let mins = parseInt(screenTimeEl.textContent.split(' ')[1]);
                
                mins += Math.floor(Math.random() * 5) - 2;
                if (mins < 0) {
                    mins += 60;
                    hours--;
                }
                if (mins >= 60) {
                    mins -= 60;
                    hours++;
                }
                
                screenTimeEl.textContent = `${hours}h ${mins}m`;
            }, 30000);

            // Handle tab switching
            const tabs = document.querySelectorAll('.tab');
            tabs.forEach(tab => {
                tab.addEventListener('click', () => {
                    tabs.forEach(t => t.classList.remove('active'));
                    tab.classList.add('active');
                });
            });

            // Handle date range buttons
            const dateButtons = document.querySelectorAll('.date-range button');
            dateButtons.forEach(button => {
                button.addEventListener('click', () => {
                    dateButtons.forEach(b => b.classList.remove('active'));
                    button.classList.add('active');